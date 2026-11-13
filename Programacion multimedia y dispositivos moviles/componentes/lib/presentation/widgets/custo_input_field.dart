import 'package:flutter/material.dart';

TextFormField CustomInputField() {
    return TextFormField(
      autofocus: true,
              //initialValue: "Borja Ros Perez",
      textCapitalization: .words,
      onChanged: (value){
        print(value);
      },
      validator: (value){
        if(value == null) return 'Esta campo es requerido';
          return value.length < 3 ? 'Minimo de 3 caracteres':null;
      },
      autovalidateMode: .onUserInteraction,
      decoration: InputDecoration(
        hintText: 'Nombre del usuario',
        labelText: 'Nombre',
        helperText: 'Solo letras',
        counterText: 'Contador',
        suffixIcon: ,
        prefixIcon: Icon(Icons.group_off_outlined),
        icon: Icon(Icons.assignment_ind_outlined),
        /*
        border: OutlineInputBorder(
          borderRadius: .only(
            bottomLeft: Radius.circular(10),
            bottomRight: Radius.circular(10)
          )
        ),
        */
      ),
    );
}