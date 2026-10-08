from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton, QGridLayout, QStackedLayout, QTabWidget
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")
        
        tabs = QTabWidget()
        horizontal = QHBoxLayout();
        vertical = QVBoxLayout();
        
        tabs.setTabPosition(QTabWidget.TabPosition.North)
        tabs.setMovable(True)
        
        input = QLineEdit()
        label = QLabel("Hola")
        
        horizontal.addWidget(label)
        horizontal.addWidget(input)
        
        casilla = QCheckBox("Seleccion")
        boton = QPushButton("Pulsa")
        
        vertical.addWidget(casilla)
        vertical.addWidget(boton)
        
    
        widget1 = QWidget()
        widget1.setLayout(horizontal)
        
        widget2 = QWidget()
        widget2.setLayout(vertical)
        
        tabs.addTab(widget1, "pestaña 1") # Para poner titulo
        tabs.addTab(widget2, "pestaña 2") # Para poner titulo
            
        
   
        self.setCentralWidget(tabs)

app = QApplication([])
window = MainWindow()
window.show()

app.exec() # Poner siempre si no la ventana se cierra instant