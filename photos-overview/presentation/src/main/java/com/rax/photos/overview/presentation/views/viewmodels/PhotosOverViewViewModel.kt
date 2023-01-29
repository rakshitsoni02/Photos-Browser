package com.rax.photos.overview.presentation.views.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rax.core.viewmodels.mapExceptionMessage
import com.rax.photos.overview.domain.usecases.GetPhotosOverviewUseCase
import com.rax.photos.overview.presentation.views.popups.PhotosOverViewPopUp
import com.rax.photos.overview.presentation.views.states.PhotosOverViewViewState
import com.rax.photos.overview.presentation.views.viewmodels.inputs.PhotosOverViewInputs
import com.rax.photos.overview.presentation.views.viewmodels.outputs.PhotosOverViewOutputs
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PhotosOverViewViewModel @Inject constructor(
    private val getPhotos: GetPhotosOverviewUseCase,
) : ViewModel(), PhotosOverViewInputs, PhotosOverViewOutputs {

    private val _viewState = MutableLiveData<PhotosOverViewViewState>()
    private val _popUp = MutableLiveData<PhotosOverViewPopUp?>()

    private val compositeDisposable = CompositeDisposable()

    val inputs: PhotosOverViewInputs = this
    val outputs: PhotosOverViewOutputs = this

    override fun onViewCreated() {
        val disposable = getPhotos(Unit)
            .map<PhotosOverViewViewState> { PhotosOverViewViewState.PhotoDetails(photos = it) }
            .startWith(Single.just(PhotosOverViewViewState.Loading))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .onErrorReturn { throwable ->
                val message = throwable.mapExceptionMessage()
                _popUp.postValue(
                    PhotosOverViewPopUp.Snackbar(
                        message = message
                    )
                )
                PhotosOverViewViewState.Error
            }
            .subscribe { viewState ->
                _viewState.postValue(viewState)
            }
        compositeDisposable.add(disposable)
    }

    override fun onPopUpDismissed() {
        _popUp.value = null
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    //outputs
    override val popUp: LiveData<PhotosOverViewPopUp?>
        get() = _popUp
    override val viewState: LiveData<PhotosOverViewViewState>
        get() = _viewState
}