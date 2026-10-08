from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton, QGridLayout, QStackedLayout
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")
        
        plantilla = QVBoxLayout() # Contenedor total
        plantilla1 = QHBoxLayout()
        self.colores = QStackedLayout();
        
        boton = QPushButton("Red")
        boton1 = QPushButton("Green")
        boton2 = QPushButton("Yellow")
        
        plantilla1.addWidget(boton)
        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)
        
        self.colores.addWidget(Color("red"))
        self.colores.addWidget(Color("green"))
        self.colores.addWidget(Color("yellow"))
        
        boton.clicked.connect(lambda: self.colores.setCurrentIndex(0))
        boton1.clicked.connect(lambda: self.colores.setCurrentIndex(1))
        boton2.clicked.connect(lambda: self.colores.setCurrentIndex(2))
        
        plantilla.addLayout(plantilla1)
        plantilla.addLayout(self.colores)
        
        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

app = QApplication([])
window = MainWindow()
window.show()

app.exec() # Poner siempre si no la ventana se cierra instant