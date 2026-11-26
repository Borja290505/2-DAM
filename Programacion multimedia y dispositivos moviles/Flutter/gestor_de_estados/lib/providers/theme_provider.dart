import 'package:flutter/material.dart';

class ThemeProvider extends ChangeNotifier{
  //Iniciamos el provider
  ThemeMode _themeMode = ThemeMode.dark;

  ThemeMode get themeMode => _themeMode;
  
  void cambiarTheme(){
    _themeMode = _themeMode == ThemeMode.light ? ThemeMode.dark: ThemeMode.light;
  }
}