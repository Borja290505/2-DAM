from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        plantilla1 = QVBoxLayout(); # Contenedor total
       

        
        self.boton1 = QPushButton();
        self.boton2 = QPushButton();
        self.boton3 = QPushButton();

        self.boton1.setText("Boton 1");
        self.boton2.setText("Boton 2");
        self.boton3.setText("Boton 3");
        
        plantilla1.setContentsMargins(10,10,10,10) # Para poner padding
        plantilla1.setSpacing(40) # Para poner margen entre widgets

        self.boton1.clicked.connect(self.botonClickeado)
        self.boton2.clicked.connect(self.botonClickeado)
        self.boton3.clicked.connect(self.botonClickeado)
        

       
        plantilla1.addWidget(self.boton1)
        plantilla1.addWidget(self.boton2)
        plantilla1.addWidget(self.boton3)

        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)
      

    def botonClickeado (self):
            print(f"{self.sender().text()} clickeado") # La f al principio sirve para añadir una funcion aparte de el texto a printear

       
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant