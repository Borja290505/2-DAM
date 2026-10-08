from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        plantilla1 = QHBoxLayout(); # Contenedor total
        plantilla2 = QVBoxLayout(); # Conjunto vertical de 3 colores
        plantilla3 = QVBoxLayout(); # Unico color


        
        plantilla2.addWidget(Color("red"))        
        plantilla2.addWidget(Color("yellow"))   
        plantilla2.addWidget(Color("blue")) 

        plantilla3.addWidget(Color("red"))        
        plantilla3.addWidget(Color("yellow"))   
        plantilla3.addWidget(Color("blue"))     

      

        plantilla1.addLayout(plantilla2)
        plantilla1.addWidget(Color("Orange"))
        plantilla1.addLayout(plantilla3)
     

        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant