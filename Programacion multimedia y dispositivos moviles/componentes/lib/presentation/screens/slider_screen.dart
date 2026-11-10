import 'package:flutter/material.dart';

class SliderScreen extends StatefulWidget {
   
  const SliderScreen({Key? key}) : super(key: key);

  @override
  State<SliderScreen> createState() => _SliderScreenState();
}

class _SliderScreenState extends State<SliderScreen> {

  double _valorSlider = 40;
  bool activo = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Slider & Checks'),),
      body: Column(
         children: [
          Slider.adaptive(
            max: 400,
            min: 30,
            value: _valorSlider,
            onChanged: activo
              ? (value){
              print(value);
              setState(() {
                _valorSlider=value ;
              });
            }
            :null
          ),

          /*
          Checkbox.adaptive(
            value: activo, 
            onChanged: (value){
              setState(() {
                activo = value ?? true;
              });
            }
          ),
          */

          /*
          Switch.adaptive(
            value: activo, 
            onChanged: (value){
              setState(() {
                activo = value ?? true;
              });
          }),
          */

          /*
          CheckboxListTile.adaptive(
            title: Text('Habilitar Slider'),
            value: activo, 
            onChanged:(value){
              setState(() {
                activo = value ?? true;
              });
            }
          ),
          */

          SwitchListTile.adaptive(
            title: Text('Habilitar Switch'),
            value: activo, 
            onChanged:(value){
              setState(() {
                activo = value;
              });
            }
          ),
          Expanded(
            child: SingleChildScrollView(
            child: Image(
              image: NetworkImage('https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png'),
              fit: BoxFit.contain,
              width: _valorSlider,
            )
          )
          )
          
         ],
      ),
    );
  }
}