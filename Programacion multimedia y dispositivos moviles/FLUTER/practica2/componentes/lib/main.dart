import 'package:flutter/material.dart';
import './presentation/screen/listview_screen.dart';


class nameScreen extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: listview_screen(),
     ),
   );
  }
}