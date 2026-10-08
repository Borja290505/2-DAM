from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")
        plantilla = QVBoxLayout() # Para plantilla vertical, para horizonta es QHBoxLayout


        plantilla.addWidget(Color("red"))        
        plantilla.addWidget(Color("yellow"))   
        plantilla.addWidget(Color("blue"))   
        plantilla.addWidget(Color("purple"))   
        plantilla.addWidget(Color("red"))   

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant