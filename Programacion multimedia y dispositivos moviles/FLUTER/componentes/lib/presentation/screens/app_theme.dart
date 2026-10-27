import 'package:flutter/material.dart';

class AppTheme(){

  static const Color primary = Colors.pink;
  static const Color secondary = Colors.indigo;
  static const Color terciary = Colors.greenAccent;

  static final ThemeData ligthTheme = ThemeData.light().copyWith(
    useMaterial3: false,
    primaryColor: Colors.greenAccent,

    appBarTheme: AppBarTheme(
      backgroundColor: terciary,
      elevation: 0,
    )
  );

  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(
    useMaterial3: false,
    primaryColor: Colors.deepOrangeAccent,
  );
}