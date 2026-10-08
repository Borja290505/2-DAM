from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton, QGridLayout, QStackedLayout, QTabWidget
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")
        
        tabs = QTabWidget()
       
        tabs.setTabPosition(QTabWidget.TabPosition.North)
        tabs.setMovable(True)
        tabs.addTab(Color("Red"), "Rojo") # Para poner titulo
        tabs.addTab(Color("Yellow"), "Yellow") # Para poner titulo
        tabs.addTab(Color("Blue"), "Blue") # Para poner titulo
        tabs.addTab(Color("Orange"), "Orange") # Para poner titulo
        tabs.addTab(Color("Purple"), "Purple") # Para poner titulo
        
                
   
        self.setCentralWidget(tabs)

app = QApplication([])
window = MainWindow()
window.show()

app.exec() # Poner siempre si no la ventana se cierra instant