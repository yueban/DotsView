# DotsView
Using it with ViewPager,ScrollView,etc......   

<img src="https://raw.githubusercontent.com/yueban/DotsView/master/DotsVIew.gif" width="300" alt="Screenshot"/>

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