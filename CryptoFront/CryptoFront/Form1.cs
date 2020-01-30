using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CryptoFront
{
    public partial class Form1 : Form
    {
        ServerCommunication server = new ServerCommunication();
        public Form1()
        {
            InitializeComponent();

            LoadNewQR();
        }
        private void GenerateQRButton_Click(object sender, EventArgs e)
        {
            LoadNewQR();
        }

        private void LoadNewQR()
        {
            string path = QRUtils.GetQRCode(server.URL);

            QRPictureBox.Image = new Bitmap(new Bitmap(path), 230, 230);

            QRPictureBox.Invalidate();
        }
    }
}
