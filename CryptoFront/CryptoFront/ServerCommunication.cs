using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace CryptoFront
{
    class ServerCommunication
    {
        //public string IP { get; set; }
        public string URL { get; set; }

        public ServerCommunication()
        {
            URL = GetURL();
        }

        public string GetURL()
        {
            //string result = "error";

            //HttpWebRequest request = (HttpWebRequest)WebRequest.Create(URL);
            //request.AutomaticDecompression = DecompressionMethods.GZip;

            //using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
            //using (Stream stream = response.GetResponseStream())
            //using (StreamReader reader = new StreamReader(stream))
            //{
            //    result = reader.ReadToEnd();
            //}

            //return result;

            return IPUtils.GetFullURL("values");
        }
    }
}
