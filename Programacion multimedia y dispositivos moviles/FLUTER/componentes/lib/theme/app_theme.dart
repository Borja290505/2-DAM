import 'package:flutter/material.dart';

class AppTheme {

  // Color primario
  static const Color primary = Colors.orange;
  static const Color secondary = Colors.yellow;

  // Tema Light
  static final ThemeData lightTheme = ThemeData.light().copyWith(
      //Color primario
      primaryColor: primary,
      // AppBar
      appBarTheme: AppBarTheme(
          backgroundColor: primary,
          elevation: 0,
        )
  );




  // Tema Halloween
  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(
    //Color primario
    primaryColor: Colors.orangeAccent,
    primaryColorDark: Colors.orangeAccent,
    

    //scaffoldBackgroundColor: Colors.blueGrey
  );
}