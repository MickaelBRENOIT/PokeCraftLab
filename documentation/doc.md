# PokeCraftLab

## Setting up Splashcreen

### SplashScreen

The logo was created thanks to DALL-E 3.<br/>
Prompt used: *Create a logo featuring the head of a fluffy, fictional creature inspired by Pokemon. The creature should be smiling warmly, with a friendly and inviting expression. Its fur should appear soft and fluffy, giving it a cute and approachable look. The logo should be designed with a transparent background, making it suitable for various applications. The image should be centered and well-balanced, ensuring that the creature's head is the focal point of the logo. The style should be clean and simplistic, suitable for a professional logo design.*

Then I followed the UI Guide from Android documentation [Splashscreen](https://developer.android.com/develop/ui/views/launch/splash-screen).<br/>
I used [Figma](https://www.figma.com/) to create my centered backgroundless logo: *App icon without an icon background: this must be 288×288 dp and fit within a circle 192 dp in diameter.*<br/>
Note 1 :warning:: Export to SVG put an **image** tag, whereas we want **path** tags to draw our logo. Use [Convert PNG to SGV](https://png2svg.com/)
Note 2 :warning:: I tried to animate my icon with [shapeshifter](https://shapeshifter.design/) but it's not working... (Well preview is working in the tool but not Android Studio (bug ?))

