import 'package:componentes/presentation/screens/app_theme.dart';
import 'package:flutter/material.dart';
import 'presentation/screens.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      initialRoute: "/",
      routes: {
        "/"     : (BuildContext context) => HomeScreen(),
        "listview1": (context) =>   ListView1Screen(),
        "listview2": (context) =>   ListView2Screen(), 
        "alert"    : (context) =>   AlertScreen(),
        "card"     : (context) =>   CardScreen()
      },
      onGenerateRoute: (settings) => MaterialPageRoute(builder: (context) => const HomeScreen()),
      // CORREGIDO: Llamamos al método que genera el ThemeData dinámico
      theme: AppTheme(colorSeleccionado: 8).getTheme(), // Por ejemplo, 6 para usar Colors.pink
    );
  }
}
