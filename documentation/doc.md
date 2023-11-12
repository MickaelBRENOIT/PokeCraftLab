# PokeCraftLab

## Setting up Theme

### SplashScreen

The logo was created thanks to DALL-E 3.<br/>
Prompt used: *Create a logo featuring the head of a fluffy, fictional creature inspired by Pokemon. The creature should be smiling warmly, with a friendly and inviting expression. Its fur should appear soft and fluffy, giving it a cute and approachable look. The logo should be designed with a transparent background, making it suitable for various applications. The image should be centered and well-balanced, ensuring that the creature's head is the focal point of the logo. The style should be clean and simplistic, suitable for a professional logo design.*

Then I followed the UI Guide from Android documentation [Splashscreen](https://developer.android.com/develop/ui/views/launch/splash-screen).<br/>
I used [Figma](https://www.figma.com/) to create my centered backgroundless logo: *App icon without an icon background: this must be 288×288 dp and fit within a circle 192 dp in diameter.*<br/>
Note 1 :warning:: Export to SVG put an **image** tag, whereas we want **path** tags to draw our logo. Use [Convert PNG to SGV](https://png2svg.com/)<br/>
Note 2 :warning:: I tried to animate my icon with [shapeshifter](https://shapeshifter.design/) but it's not working... (Well preview is working in the tool but not Android Studio (bug ?))

### App icon

1. Right-click on "res" folder
2. Choose "Icon type: Launcher Icons (Adaptive and Legacy)"
3. On Foreground Layer upload an Asset type of image. Resize if necessary
4. On BAckground Layer choose the predominant color of uploaded image 

### Font

1. Right-click on "res" folder and new "Android Resource Directory"
2. Choose Font
3. Search a [font](https://fonts.google.com/) and download it. Rename files with lowercase and underscore.
4. Modify "Type.kt" following [MD3](https://m3.material.io/styles/typography/overview) guidelines.

### Theme

1. Go on [MD3 Builder](https://m3.material.io/theme-builder#/custom) and choose a primary, secondary and tertiary colors.
2. Take your app icon and go to [imageresizer](https://imageresizer.com/color-picker) for example and extract colors.
3. Once colors have been chosen, download files and update "Color.kt" and "Theme.kt" in your app.

In "Theme.kt" you can update your status and navigation colors

```kotlin

    val window = (view.context as Activity).window
    window.statusBarColor = colorScheme.background.toArgb()
    window.navigationBarColor = colorScheme.background.toArgb()

```