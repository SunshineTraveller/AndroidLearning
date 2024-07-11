package com.example.androidlearning.Test


/*
常用属性说明
 android:layout_width: 设置控件宽，match_parent： 和父视图一样宽; wrap_contnet:按照内容自动伸缩, 可设置固定宽 200dp
 android:layout_height: 设置控件高度,可设置为:match_parent(和父控件一样),wrap_content(按照内容自动伸缩),设置固定值(如200dp)
 android:background: 设置背景,可以是色值(如#FF0000)或图片等
 android:visibility: 可选值: visible(显示), invisible(隐藏,但是仍占据UI空间),gone(隐藏,且不占UI空间)
 android:layout_gravity: 当前控件在父控件中的位置,可选值:start(居左),end(居右),center(居中),top(居上),bottom(居下),属性可组合,用竖线分隔，如 bottom|end.
 android:gravity: 控制当前控件的子控件相对于自己的位置，
 可选址:start(居左),end(居右),top(居上),bottom(居下),center_horizontal(水平居中),center_vertical(垂直居中),center(水平和垂直方向都居中)


 //MARK: - RelativeLayout 相对布局
 相对布局，顾名思义，特点就是可以相对某个View做相对布局

 android:layout_above: 当前控件整体位于目标控件之上
 android:layout_below: 当前控件整体位于目标控件之下
 android:layout_toStartOf: 当前控件整体位于目标控件左侧.
 android:layout_toEndOf: 当前控件整体位于目标控件右侧.
 android:layout_alignStart: 和目标控件左对齐.
 android:layout_alignEnd: 和目标控件右对齐.
 android:layout_alignTop: 和目标控件上对齐.
 android:layout_alignBottom: 和目标控件下对齐.
 android:layout_centerInParent: 设置是否在父控件中居中(横向和纵向).
 android:layout_alignParentStart: 设置是否和父控件左对齐.
 android:layout_alignParentEnd: 设置是否和父控件右对齐.
 android:layout_alignParentTop: 设置是否和父控件上对齐(因为默认就是上对齐的,所以就不用设置了)
 android:layout_alignParentBottom: 设置是否和父控件下对齐.

 //MARK: - LinearLayout 线性布局
 layout_weight: 当前控件在线性布局中的比重
 orientation: 线性布局的方向， horizontal为水平线性，vertical 为垂直线性

*/