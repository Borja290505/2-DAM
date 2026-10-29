from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout
from Color import Color

class MainWindow(QMainWindow):     
    def __init__(self): 
        super().__init__() 
        self.setWindowTitle("MiAplicacion")

        plantilla1 = QHBoxLayout(); 
        plantilla2 = QVBoxLayout(); 
        plantilla3 = QVBoxLayout(); 
        
        plantilla2.addWidget(Color("red"))        
        plantilla2.addWidget(Color("yellow"))   
        plantilla2.addWidget(Color("blue")) 

        plantilla3.addWidget(Color("red"))        
        plantilla3.addWidget(Color("yellow"))   
        plantilla3.addWidget(Color("blue"))     

        plantilla1.addLayout(plantilla2)
        plantilla1.addWidget(Color("Orange"))
        plantilla1.addLayout(plantilla3)
     
        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)
                
app = QApplication([])
window = MainWindow()
window.show()


app.exec() 