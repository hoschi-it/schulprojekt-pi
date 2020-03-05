using System;
using System.Net;
using System.IO;
using Newtonsoft.Json.Linq;
using System.Text;

namespace RestAPI_Localhost
{
    class Program
    {
        private const string WEBSERVICE_URL = "http://localhost:8080/schulprojekt/Einloggen.php";
        static void Main(string[] args)
        {
            try
            {
                WebRequest webRequest = WebRequest.Create(WEBSERVICE_URL);
                JObject jsonObj = new JObject();

                SendPost(WEBSERVICE_URL, "Blubber");

                if (webRequest != null)
                {
                    //webRequest.Method = "GET";
                    //webRequest.ContentType = "application/json";
                    //webRequest.Headers["X-API-Key"] = "tmBc5rzoAP"; //Userkey

                    //Get the response 
                    WebResponse wr = webRequest.GetResponseAsync().Result;
                    Stream receiveStream = wr.GetResponseStream();
                    StreamReader reader = new StreamReader(receiveStream);

                    //Get it into a string
                    string content = reader.ReadToEnd();
                    //Parse to JSON-Object
                    jsonObj = JObject.Parse(content);
                    Console.Write(content);
                    Console.Read();

                }
            }
            catch(Exception ex)
            {

            }

        }

        public static string SendPost(string url, string postData)
        {
            string webpageContent = string.Empty;

            try
            {
                byte[] byteArray = Encoding.UTF8.GetBytes(postData);

                HttpWebRequest webRequest = (HttpWebRequest)WebRequest.Create(url);
                webRequest.Method = "POST";
                webRequest.ContentType = "application/x-www-form-urlencoded";
                webRequest.ContentLength = byteArray.Length;

                using (Stream webpageStream = webRequest.GetRequestStream())
                {
                    webpageStream.Write(byteArray, 0, byteArray.Length);
                }

                using (HttpWebResponse webResponse = (HttpWebResponse)webRequest.GetResponse())
                {
                    using (StreamReader reader = new StreamReader(webResponse.GetResponseStream()))
                    {
                        webpageContent = reader.ReadToEnd();
                    }
                }
            }
            catch (Exception ex)
            {
                //throw or return an appropriate response/exception
            }

            return webpageContent;
        }
    }
}