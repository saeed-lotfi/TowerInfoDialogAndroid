[![](https://jitpack.io/v/saeed-lotfi/TowerDialogAndroid.svg)](https://jitpack.io/#saeed-lotfi/TowerDialogAndroid)


# TowerDialogAndroid


   <img src="https://raw.githubusercontent.com/saeed-lotfi/TowerInfoDialogAndroid/master/raw/success.png" width="300"> <img src="https://raw.githubusercontent.com/saeed-lotfi/TowerInfoDialogAndroid/master/raw/error.png" width="300">




## How To Install

To get a Git project into your build:

* Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

* Step 2. Add the dependency

```
dependencies {
	  implementation 'com.github.saeed-lotfi:TowerInfoDialogAndroid:1.0.0'
}
```
## How To Use

```
val dialog = TowerDialog.Companion.Builder()
    // set context required
    .setContext(this)
    .setTitle("custom title")
    .setIsSuccess(true)
    .setMessage(" The dialog box ")
    // set title bold default is false
    .setTileIsBold(true)
    .setButtonText("Done")
    .build()

dialog.show {
    // manage click
}

```

