from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        dial = QDial()
        dial.setRange(0, 100) #  Para poner rango
        dial.setNotchesVisible = True # Para mostrar las lineas de pista
        
        
       
        dial.valueChanged.connect(self.valorcambiado)
        dial.sliderMoved.connect(self.sliderTocado)
        
        self.setCentralWidget(dial)
        
            

    def valorcambiado(self, valor):
       print("Nuevo numero", valor)

    def sliderTocado(self, valor):
        print("Slider tocado", valor)
        
    

    
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant