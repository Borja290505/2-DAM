from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QBoxLayout, QHBoxLayout, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout
from Color import Color

class MainWindow(QMainWindow): 

    def __init__(self):
        super().__init__() 
        self.setWindowTitle("MiAplicacion")
        plantilla = QHBoxLayout() 


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


app.exec() 