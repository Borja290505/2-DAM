from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QApplication, QDialog, QDialogButtonBox, QLabel, QVBoxLayout

class CustomDialog(QDialog):
    def __init__(self,parent=None):
        super().__init__()
        self.setWindowTitle("MiAplicacion")

        QBtn = QDialogButtonBox.StandardButton.Ok | QDialogButtonBox.StandardButton.Cancel

        self.dialogBox = QDialogButtonBox(QBtn)

        self.dialogBox.accepted.connect(self.accept)
        self.dialogBox.rejected.connect(self.reject)

        self.plantilla = QVBoxLayout()
        mensaje = QLabel("Algo ha sucedido ¿Todo OK?")
        
        self.plantilla.addWidget(mensaje)
        self.plantilla.addWidget(self.dialogBox)
        
        self.setLayout(self.plantilla)
        
app = QApplication([])
window = CustomDialog()
window.show()
app.exec()
