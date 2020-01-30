//using System;
//using System.Collections.Generic;
//using System.Diagnostics;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace RC5SharingSystem.Utils
//{
//    public class IPUtils
//    {
//        public static string GetLocalIP()
//        {
//            Process p = new Process();
//            p.StartInfo.UseShellExecute = false;
//            p.StartInfo.RedirectStandardOutput = true;
//            p.StartInfo.FileName = "E:\\Projects\\RC5SharingSystem\\RC5SharingSystem\\bin\\Debug\\netcoreapp2.1\\ipconfigcmd.bat";
//            p.Start();
//            string output = p.StandardOutput.ReadToEnd();
//            p.WaitForExit();

//            string[] lines = output.Split('\n');
//            string[] words = lines[35].Split(' ');

//            return words[words.Length - 1].Trim();
//        }

//        public static string GetLocalPort()
//        {
//            return 45455.ToString();
//        }

//        public static string GetFullURL(string controller)
//        {
//            StringBuilder sb = new StringBuilder();
//            sb.Append("https://");
//            sb.Append(GetLocalIP());
//            sb.Append(":");
//            sb.Append(GetLocalPort());
//            sb.Append("/api/");
//            sb.Append(controller);
//            return sb.ToString();
//        }
//    }
//}
