# AlGallery
Easy to use Image Gallery / Viewpager with the ability to zoom. Based on ZGallery

[![](https://jitpack.io/v/AlCabohne/AlGallery.svg)](https://jitpack.io/#AlCabohne/AlGallery)



## Installation

Add this to your **root** build.gradle file (not your module build.gradle file) :
```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
...
ext{
    supportLibVersion = "/*your current version of support library*/"
}
```

Add this to your module `build.gradle` file:
```java
dependencies {
  ...
    implementation 'com.github.AlCabohne:AlGallery:v0.1.3'
}
```

## Usage

```java
GridBuilder.withURL(this, /*your string arraylist of image urls*/)
                .setTitle("Some Title")
                .setToolbarTitleColor(R.color.colorAccent)
                .setShowBackButton(GalleryConstants.GalleryOptions.BACK_BUTTON_WHITE)
                .setSpanCount(3)
                .setGridImgPlaceHolder(R.color.colorPrimary)
                .show();

GalleryBuilder.withURL(this, /*your string arraylist of image urls*/)
                .setToolbarTitleColor(R.color.colorAccent)
                .setShowBackButton(GalleryConstants.GalleryOptions.BACK_BUTTON_WHITE)
                .setFullscreenMode(false)
                .setTitle("Damage Templates")
                .show();

GridBuilder.withID(this, /*your ResourceID arraylist/int[] of drawables*/)
                . ...

GalleryBuilder.withID(this, /*your ResourceID arraylist/int[] of drawables*/)
                . ...

```

# License

> Copyright 2018 AlCabohne

> Copyright 2016 mzelzoghbi

> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
