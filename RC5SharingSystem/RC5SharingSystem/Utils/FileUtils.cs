using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace RC5SharingSystem.Utils
{
    public class FileUtils
    {
        public static void SaveTextToFile(Information info)
        {
            File.WriteAllText(info.Path, info.Contents);
        }
    }
}
