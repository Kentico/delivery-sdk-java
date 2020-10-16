# Kontent Sample Spring Android (Java)

The showcase of the [Android](https://www.android.com/) application displaying data from Kontent.

![Application walkthrough](./adroid-app-showcase.gif)

## Get started

First, [build the whole monorepo](../README.md#Build-and-Test) and then you could install the app from:

* Debug version - `/sample-app-android/build/outputs/apk/debug/sample-app-android-debug.apk`
* Unsigned release version - `/sample-app-android/build/outputs/apk/release/sample-app-android-release-unsigned.apk`

> Alternatively, you could run [the application on your Android device](https://developer.android.com/studio/run), alternatively [use the Android emulator](https://developer.android.com/studio/run/emulator).

## Features

Application is showcasing listing-detail screens with three content types `Article`, `Coffee`, and `Cafe`. The listings are selectable in the Menu.

> This application is about to demonstrate it is possible to load data from Kentico Kontent using Java SDK. It is not meant to be used as a boilerplate.

### Instantiating Delivery client

It is important to instantiate the delivery with the constructor that disables the template engine. The template engine is meant to be used on the web platform. **Use constructor `DeliveryClient#DeliveryClient(DeliveryOptions, TemplateEngineConfig)` and set second parameter to `null**`** for Android development.

Use the following constructor (see the [sample](./src/main/java/com/github/kentico/delivery_android_sample/data/source/DeliveryClientProvider.java)):

```java
DeliveryClient client = new DeliveryClient(new DeliveryOptions(AppConfig.KONTENT_PROJECT_ID), null);
```

### Data loading using RxJava

All the data loaded from Kentico Kontent is using [RxJava](https://github.com/ReactiveX/RxJava) approach. Basically, the `CompletionStage` returned from Kontent Java SDK is wrapped to the `Observable`. This allows to easily synchronize IO and UI operation with proper thread. Take a look i.e. to [`ArticlesKontentSource#getArticles` method](./src/main/java/com/github/kentico/delivery_android_sample/data/source/articles/ArticlesKontentSource.java#L40) to see the actual implementation using `io.reactivex.rxjava3:rxjava` and `io.reactivex.rxjava3:rxandroid` packages.

```java
Observable.fromCompletionStage(client.getItems(Article.class))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<List<Article>>() {
          // ...
        });
```

### Strongly-typed models with models

This showcase is using models for `Article`, `Coffee`, and `Cafe` type. You could use the [model generator](../kontent-delivery-generators/README.md) for generating models like that.

The app is registering these models in [DeliveryClientProvider.java](./src/main/java/com/github/kentico/delivery_android_sample/data/source/DeliveryClientProvider.java) and it is using `registerType` method to register the model to the client.

> ⚠ Method `scanClasspathForMappings` does not work in the Android environment, because of the differences in Android Dalvik VM vs. Java VM the scanning library is not usable here. That is why `registerType` method should be used instead.

![Analytics](https://kentico-ga-beacon.azurewebsites.net/api/UA-69014260-4/Kentico/kontent-java-packages/sample-app-android?pixel)
