ImageFetcher Library
=========================

This folder contains the main library which should be linked against as an
Android library project in your application.
It's used LruCache, Asynchronous load image

Useage
-------
 * init ImageFetcher

```
ImageFetcher mImageFetcher = UIUtils.getImageFetcher(getActivity());
mImageFetcher.setImageFadeIn(false);
```
 * load image include loadImage and load ThumnailImage

```
mImageFetcher.loadThumbnailImage(speakerImageUrl, speakerImageView, R.drawable.person_image_empty);
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
License
=======

    Copyright 2012 Crossle Song

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


![Example Image][3]

[3]: https://github.com/guamier/ImageFetcher/raw/master/screen1.png
