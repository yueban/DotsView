# DotsView
Using it with ViewPager,ScrollView,etc......   

<img src="https://raw.githubusercontent.com/yueban/DotsView/master/DotsView.gif" width="300" alt="Screenshot"/>
## Gradle
DotsView is avaiable in [JCenter](https://bintray.com/bintray/jcenter?filterByPkgName=DotsView)

**Gradle dependency:**
```gradle
compile 'com.bigfat.dotsview:library:1.0.0'
```

## Usage
Define in xml:
```xml
<com.bigfat.library.DotsView
    android:id="@+id/dv_vertical"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:padding="8dp"
    app:dv_colorSelected="#FF0000"
    app:dv_colorUnselected="#00FF00"
    app:dv_count="3"
    app:dv_current="0"
    app:dv_dotRadius="6dp"
    app:dv_dotSpace="24dp"
    app:dv_orientation="horizontal" />
```

Or in code:
```java
dotsView.setOrientation(DotsView.ORIENTATION_HORIZONTAL);
dotsView.setColorSelected(Color.RED);
dotsView.setColorUnselected(Color.GREEN);
dotsView.setDotSpace(30);//30px
dotsView.setDotRadius(10);//10px
dotsView.setCount(3);
dotsView.setCurrent(0);//current selected dot
```

powered by [mingdao](http://www.mingdao.com/home)

## License

    Copyright 2015 范柏舟

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.