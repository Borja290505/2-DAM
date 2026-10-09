from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QApplication, QDialog, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton, QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar
from Color import Color
from PyQt6.QtGui import QAction,QIcon

class MainWindow(QMainWindow): # Asi se crea una clase

    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        boton = QPushButton("Pulsa Aqui")
        boton.clicked.connect(self.botonPulsado)
        self.setCentralWidget(boton)
        

    def botonPulsado(self, s):
        dig=QDialog(self)
        dig.setWindowTitle("Cuadro de dialogo")
        dig.exec()
        
app = QApplication([])
window = MainWindow()
window.show()

app.exec() # Poner siempre si no la ventana se cierra instant432