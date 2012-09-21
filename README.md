ImageFetcher Library
=========================

This folder contains the main library which should be linked against as an
Android library project in your application.

Useage
-------
 * init ImageFetcher

```
ImageFetcher mImageFetcher = UIUtils.getImageFetcher(getActivity());
mImageFetcher.setImageFadeIn(false);
```
 * load image include loadImage and load ThumnailImage

```
mImageFetcher.loadThumbnailImage(speakerImageUrl, speakerImageView,
                        R.drawable.person_image_empty);
```
 * flush close cache

```
@Override
public void onPause() {
    super.onPause();
    mImageFetcher.flushCache();
}

@Override
public void onDestroy() {
        super.onDestroy();
    mImageFetcher.closeCache();
}
```
!https://github.com/guamier/ImageFetcher/raw/master/screen1.png(Screenshot)!
