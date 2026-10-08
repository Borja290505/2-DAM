from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton, QGridLayout
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")


        plantilla = QGridLayout()
        plantilla.addWidget(Color("Red"), 0, 0)
        plantilla.addWidget(Color("Green"), 0, 1)
        plantilla.addWidget(Color("Yellow"), 1, 2)
        plantilla.addWidget(Color("Blue"), 2, 0)
      

       

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

  
           
app = QApplication([])
window = MainWindow()
window.show()

app.exec() # Poner siempre si no la ventana se cierra instant