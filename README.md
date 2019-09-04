[TOC]
# zip_java
## 1. 简介
要实现指定一个文件的路径A，然后添加到一个apk文件B 里的C路径下，拷贝后的文件名叫D，期间不存在拷贝文件的操作，这样大大增加效率
zip 本身可以添加，但必须实用相对路径，且不能指定拷贝后的文件名，所以不选用
```
old
pout "zip -gr $operationd_apk $add_file_name"
zip -gr $operationd_apk $add_file_name

pout "adb sign $operationd_apk"
adb sign $operationd_apk
```

## 2. 用法
### 2.1 增加操作
```
java -jar $zip_java_jar -a -f /Users/xxx/BusyBox_v63_apkpure.com.apk n "/Users/xxx/city2_.db" -p "assets/busybox-x86.png"
```
### 2.2 删除操作
```
java -jar $zip_java_jar -d -f /Users/xxx/BusyBox_v63_apkpure.com.apk -p "assets/busybox-x86.png
```
### 3. 代码来源
https://github.com/bit-ranger/zip4j.git
