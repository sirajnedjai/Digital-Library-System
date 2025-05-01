# نظام إدارة المكتبة الرقمية

![Java](https://img.shields.io/badge/Java-17-blue)
![OOP](https://img.shields.io/badge/OOP-Applied-success)

مشروع لنظام إدارة مكتبة رقمي مبسط باستخدام جافا ومفاهيم البرمجة الكائنية.

## ✨ الميزات الرئيسية
- إدارة الكتب (ورقية/إلكترونية)
- تسجيل المستعيرين
- عمليات الإعارة والاسترجاع
- البحث عن الكتب والمستعيرين
- واجهة نصية سهلة الاستخدام

## 🏗️ هيكل المشروع
```
src/
├── models/      # الأصناف الأساسية (كتاب، مستعير، عملية إعارة)
├── services/    # خدمات النظام
└── Main.java    # نقطة البدء
```

## 🚀 كيفية التشغيل
```bash
git clone https://github.com/اسمك-المستخدم/Digital-Library-System.git
cd Digital-Library-System
javac src/Main.java
java src/Main
```

## 📚 مفاهيم OOP المطبقة
| المفهوم         | طريقة التطبيق                      |
|----------------|-----------------------------------|
| التغليف         | استخدام private مع getters/setters |
| الوراثة         | Book ← PaperBook, EBook           |
| تعدد الأشكال     | واجهة ILibraryItem                |
| التجريد         | صنف Book مجرد                     |

## 📧 معلومات التسليم
الاسم :سراج الدين
اللقب : نجعي
الفوج : 2 
البريد الالكتروني : sirajeddinenedjai@gmail.com 