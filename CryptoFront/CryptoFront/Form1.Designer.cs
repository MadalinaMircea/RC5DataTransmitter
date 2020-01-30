namespace CryptoFront
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.QRPictureBox = new System.Windows.Forms.PictureBox();
            this.GenerateQRButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.QRPictureBox)).BeginInit();
            this.SuspendLayout();
            // 
            // QRPictureBox
            // 
            this.QRPictureBox.Location = new System.Drawing.Point(124, 136);
            this.QRPictureBox.Name = "QRPictureBox";
            this.QRPictureBox.Size = new System.Drawing.Size(300, 300);
            this.QRPictureBox.TabIndex = 0;
            this.QRPictureBox.TabStop = false;
            // 
            // GenerateQRButton
            // 
            this.GenerateQRButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.GenerateQRButton.Location = new System.Drawing.Point(462, 223);
            this.GenerateQRButton.Name = "GenerateQRButton";
            this.GenerateQRButton.Size = new System.Drawing.Size(144, 81);
            this.GenerateQRButton.TabIndex = 2;
            this.GenerateQRButton.Text = "Generate new QR code";
            this.GenerateQRButton.UseVisualStyleBackColor = true;
            this.GenerateQRButton.Click += new System.EventHandler(this.GenerateQRButton_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(78, 73);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(601, 29);
            this.label1.TabIndex = 3;
            this.label1.Text = "Scan the QR code to share information with the PC";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(758, 514);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.GenerateQRButton);
            this.Controls.Add(this.QRPictureBox);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.QRPictureBox)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox QRPictureBox;
        private System.Windows.Forms.Button GenerateQRButton;
        private System.Windows.Forms.Label label1;
    }
}

