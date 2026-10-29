from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton, QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar
from Color import Color
from PyQt6.QtGui import QAction,QIcon

class MainWindow(QMainWindow): # Asi se crea una clase

    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")
      
      
        etiqueta = QLabel("Etiqueta")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignCenter) # Simplemente para alinearlo al centro
   
        barra = QToolBar()
        barra.setIconSize(QSize(16,16))
        self.addToolBar(barra)
        
        boton = QAction(QIcon("icons/bug.png"),"Mi boton", self)
        boton.setStatusTip("Este boton no hace nada") # Para que al hacer hover sobre el boton salga el tip (necesita lo de abajo tambien)
        boton.triggered.connect(self.botonpulsado)

        barra.addSeparator()

        boton2 = QAction(QIcon("icons/cake.png"),"Mi otro boton", self)
        boton2.setStatusTip("Este es mi otro boton") # Para que al hacer hover sobre el boton salga el tip (necesita lo de abajo tambien)
        boton2.triggered.connect(self.botonpulsado)

        barra.addSeparator()

        barra.addWidget(QLabel("texto"))
        barra.addWidget(QCheckBox("seleccion"))

        self.setStatusBar(QStatusBar(self)) # Esto!

        barra.addAction(boton)
        barra.addAction(boton2)
        self.setCentralWidget(etiqueta)

    def botonpulsado(self, s):
        print("Pulsado", s)
        
app = QApplication([])
window = MainWindow()
window.show()

app.exec() # Poner siempre si no la ventana se cierra instant