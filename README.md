- [1. zip_java](#1-zipjava)
  - [1.1. 简介](#11-%e7%ae%80%e4%bb%8b)
  - [1.2. 用法](#12-%e7%94%a8%e6%b3%95)
    - [1.2.1. 增加操作](#121-%e5%a2%9e%e5%8a%a0%e6%93%8d%e4%bd%9c)
    - [1.2.2. 删除操作](#122-%e5%88%a0%e9%99%a4%e6%93%8d%e4%bd%9c)
    - [1.2.3. 代码来源](#123-%e4%bb%a3%e7%a0%81%e6%9d%a5%e6%ba%90)
# 1. zip_java
## 1.1. 简介
要实现指定一个文件的路径A，然后添加到一个apk文件B 里的C路径下，拷贝后的文件名叫D，期间不存在拷贝文件的操作，这样大大增加效率
zip 本身可以添加，但必须实用相对路径，且不能指定拷贝后的文件名，所以不选用
```
old
pout "zip -gr $operationd_apk $add_file_name"
zip -gr $operationd_apk $add_file_name

pout "adb sign $operationd_apk"
adb sign $operationd_apk
```

## 1.2. 用法
### 1.2.1. 增加操作
```
java -jar $zip_java_jar -a -f /Users/xxx/BusyBox_v63_apkpure.com.apk n "/Users/xxx/city2_.db" -p "assets/busybox-x86.png"
```
### 1.2.2. 删除操作
```
java -jar $zip_java_jar -d -f /Users/xxx/BusyBox_v63_apkpure.com.apk -p "assets/busybox-x86.png
```
### 1.2.3. 代码来源
https://github.com/bit-ranger/zip4j.git
