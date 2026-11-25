

import 'package:material_ui/material_ui.dart';

class LoginProvider extends ChangeNotifier {
  // 1 - Los valores del estado
  String _email = '';
  String _password = '';

  // 2 - Getters para poder LEER el estado
  String get email => _email;
  String get password => _password;
  

  // 3 - Funciones para poder MODIFICAR el estado
  void guardarDatos(String email, String password) {
    _email = email;
    _password = password;
    notifyListeners();
  }

  void cerrarSesion() {
    _email = '';
    _password = '';
    notifyListeners();
  }
}