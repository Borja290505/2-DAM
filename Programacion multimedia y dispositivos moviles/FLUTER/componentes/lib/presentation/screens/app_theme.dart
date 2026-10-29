import 'package:flutter/material.dart';

const listaColores = <Color>[
  Colors.black,
  Colors.white,
  Colors.orangeAccent,
  Colors.yellow,
  Colors.yellowAccent,
  Colors.purple,
  Colors.pink,
  Colors.green,
  Colors.lightBlue
];

class AppTheme { 
  final int colorSeleccionado;

  
  new({
    this.colorSeleccionado = 0,
  }): assert(colorSeleccionado >= 0,"El color seleccionado debe ser mayor que 0"),
      assert(colorSeleccionado < listaColores.length,"El color seleccionado debe ser igual o menor que ${listaColores.length}");

  ThemeData getTheme() => ThemeData(
    useMaterial3: true,
    colorScheme: ColorScheme.fromSeed(seedColor: listaColores[colorSeleccionado]),
  );


  static const Color primary = Colors.pink;
  static const Color secondary = Colors.indigo;
  static const Color terciary = Colors.greenAccent;

  static final ThemeData lightTheme = ThemeData.light().copyWith(
    primaryColor: Colors.greenAccent,
    appBarTheme: const AppBarTheme(
      backgroundColor: terciary,
      elevation: 0,
    ),
  );

  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(
    primaryColor: Colors.deepOrangeAccent,
  );
}
