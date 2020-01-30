using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace RC5SharingSystem.Utils
{
    public class Information
    {
        public string Path { get; set; }
        public string Contents { get; set; }

        public Information(string path, string contents)
        {
            Path = path;
            Contents = contents;
        }
    }
}
