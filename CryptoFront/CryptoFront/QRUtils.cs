using QRCoder;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CryptoFront
{
    class QRUtils
    {
        public static string GetQRCode(string info)
        {
            QRCodeGenerator qrGenerator = new QRCodeGenerator();

            QRCodeData qrCodeData = qrGenerator.CreateQrCode(info, QRCodeGenerator.ECCLevel.Q);

            QRCode qrCode = new QRCode(qrCodeData);
            Bitmap qrCodeImage = qrCode.GetGraphic(20);
            string path = Environment.CurrentDirectory + "/barcode.jpg";
            qrCodeImage.Save(path, System.Drawing.Imaging.ImageFormat.Jpeg);
            return path;
        }
    }
}
