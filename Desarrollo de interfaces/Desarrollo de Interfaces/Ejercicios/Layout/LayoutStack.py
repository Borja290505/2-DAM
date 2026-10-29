from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout, QGroupBox, QRadioButton, QGridLayout, QStackedLayout
from Color import Color

class MainWindow(QMainWindow): 
    
    def __init__(self): 
        super().__init__() 
        self.setWindowTitle("MiAplicacion")

        plantilla = QStackedLayout()
        plantilla.addWidget(Color("Red"))
        plantilla.addWidget(Color("Green"))
        plantilla.addWidget(Color("Yellow"))
     
        plantilla.setCurrentIndex(0) 
        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

app = QApplication([])
window = MainWindow()
window.show()

app.exec() 