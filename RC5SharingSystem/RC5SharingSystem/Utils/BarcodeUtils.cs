
//using QRCoder;
//using System;
//using System.Collections.Generic;
//using System.Drawing;
//using System.IO;
//using System.Linq;
//using System.Threading.Tasks;

//namespace RC5SharingSystem.Utils
//{
//    public class BarcodeUtils
//    {
//        public static string GetQRCode(string info)
//        {
//            QRCodeGenerator qrGenerator = new QRCodeGenerator();

//            QRCodeData qrCodeData = qrGenerator.CreateQrCode(info, QRCodeGenerator.ECCLevel.Q);

//            QRCode qrCode = new QRCode(qrCodeData);
//            Bitmap qrCodeImage = qrCode.GetGraphic(20);
//            string path = Environment.CurrentDirectory + "/barcode.jpg";
//            qrCodeImage.Save(path, System.Drawing.Imaging.ImageFormat.Jpeg);
//            return path;
//        }
//    }
//}
