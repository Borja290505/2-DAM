import 'package:shared_preferences/shared_preferences.dart';

class Preferencias {
  static late SharedPreferences _preferencias;
  // 1 - Aquí creo las propiedades globales que quiero manejar en mi APP
  static bool _permisoUbicacion = false;
  static bool _permisoCamara = false;
  static bool _temaOscuro = false;
  static String _nombre = "";

  static Future init() async {
    _preferencias = await SharedPreferences.getInstance();
  }

  // 2 - Me he de crear los métodos que me devuelvan los valores

  static get nombre => _preferencias.getString('nombre') ?? _nombre;
  static get permisoUbicacion =>
      _preferencias.getBool('nombre') ?? _permisoUbicacion;
  static get permisoCamara =>
      _preferencias.getBool('nombre') ?? _permisoCamara;
  static get temaOscuro => _preferencias.getBool('nombre') ?? _temaOscuro;

  static set nombre(String nombre) {
    _nombre = nombre;
    _preferencias.setString('nombre', nombre);
  }

  static set isDarkMode(bool temaOscuro) {
    _temaOscuro = temaOscuro;
    _preferencias.setBool('dark', temaOscuro);
  }

  static set camara(bool camara) {
    _permisoCamara = camara;
    _preferencias.setBool('camara', camara);
  }
}
