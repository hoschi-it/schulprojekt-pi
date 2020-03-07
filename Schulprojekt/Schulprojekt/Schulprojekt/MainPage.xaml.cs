using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Schulprojekt {
	public partial class MainPage : ContentPage {
		
		public IList<int> Numbers { get; private set; }

		public MainPage () {
			InitializeComponent();
		}

		protected override void OnAppearing () {
			
		}

		public async Task<List<int>> RefreshDataAsync () {
			var client = new HttpClient();
			
			string response = await client.GetStringAsync("http://10.0.2.2/schulprojekt/RestController.php");

			return new List<int> {};
		}

		private async void Button_Clicked (object sender, EventArgs e) {
			var list = new List<int>();
			for (int i=0; i<10; ++i)
				list.Add(i);
			Numbers = list;

            BindingContext = this;
			
			await RefreshDataAsync();
		}
	}
}
