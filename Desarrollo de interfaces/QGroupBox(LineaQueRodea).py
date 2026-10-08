from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        plantilla1 = QHBoxLayout(); # Contenedor total
        plantilla2 = QVBoxLayout();
        plantilla3 = QVBoxLayout();

        boton1 = QPushButton("Boton 1")
        boton2 = QPushButton("Boton 2")
        boton3 = QPushButton("Boton 3")

        radio1 = QRadioButton("Radio 1")
        radio2 = QRadioButton("Radio 2")
        radio3 = QRadioButton("Radio 3")

        boton1.clicked.connect(self.textoCambiado)
        boton2.clicked.connect(self.textoCambiado)
        boton3.clicked.connect(self.textoCambiado)
        radio1.clicked.connect(self.textoCambiado)
        radio2.clicked.connect(self.textoCambiado)
        radio3.clicked.connect(self.textoCambiado)

        grupo1 = QGroupBox("Buttones")
        grupo2 = QGroupBox("Optiones")

        grupo1.setLayout(plantilla2)
        grupo2.setLayout(plantilla3)


        plantilla1.addWidget(grupo1)
        plantilla2.addWidget(boton1)
        plantilla2.addWidget(boton2)
        plantilla2.addWidget(boton3)
        plantilla1.addWidget(grupo2)
        plantilla3.addWidget(radio1)
        plantilla3.addWidget(radio2)
        plantilla3.addWidget(radio3)

        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)

    def textoCambiado(self):
        print(f"{self.sender().text()}") 
              
      
           
app = QApplication([])
window = MainWindow()
window.show()

app.exec() # Poner siempre si no la ventana se cierra instant