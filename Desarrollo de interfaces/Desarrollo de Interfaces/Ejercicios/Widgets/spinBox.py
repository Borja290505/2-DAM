from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        spinbox = QSpinBox()
        spinbox.setRange(3, 67) #  Para poner rango
        spinbox.setSuffix(" €") # Para poner sufijo
        spinbox.setSingleStep(2) # Para indicar paso 2

        spinbox.textChanged.connect(self.valorcambiado) # Para mandar el numero con sufijo a funcion, si solo quieres mandar el numero es .valueChanged 
        
        self.setCentralWidget(spinbox)

    def valorcambiado(self, valor):
       print("Nuevo numero", valor)
        
    

    
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant