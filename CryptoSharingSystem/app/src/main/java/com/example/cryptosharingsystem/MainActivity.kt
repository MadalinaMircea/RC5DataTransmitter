package com.example.cryptosharingsystem

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayInputStream
import java.net.URL
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory

class MainActivity : AppCompatActivity() {
    private var qrButton: Button? = null
    private var sendTextButton: Button? = null

    private var url: String = ""

    public var certificateString : String =
    "-----BEGIN CERTIFICATE-----\n" +
            "MIIDbzCCAlegAwIBAgIQbg2YBCn5DqxEaOmMFaPzbDANBgkqhkiG9w0BAQsFADBX\n" +
            "MVUwUwYDVQQDDExLZXlvdGkgQ29udmV5b3IgUm9vdCBDZXJ0aWZpY2F0ZSBBdXRo\n" +
            "b3JpdHkgMiAtIEZvciBkZXZlbG9wbWVudCB0ZXN0aW5nIG9ubHkhMB4XDTE5MDEw\n" +
            "ODE4NDMzNVoXDTI1MDEwNzE4NDMzNVowFjEUMBIGA1UEAwwLMTkyLjE2OC4xLjIw\n" +
            "ggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCtSQ/tUcscCO33e0Kc7bEm\n" +
            "HJgfg87sza9ZHVmc7BzDNL1nU6tlZoqEbKg92zPd/foZgxur7COimMU1BAuewX1A\n" +
            "JayLXHKJdYjIU1iS4R4JKbeSMMJoXzzFh7WfXCxuptLLvuCa0tSaCAnLoUCgF0hz\n" +
            "SFKaVaIhaMgJ5vnnKcy3iDG53gvrPsJhFSnlFAXCcO8/CTL5g+5oTAOoJFERyB7n\n" +
            "MDR7ulLyTS+da3oPs7002SVrtkum5t7kGgBdxvcQeK9AL1m8cZh/1iFUFDGHFjpB\n" +
            "ognAPEJN5tS6v/mE64xaIT4Zzhthx5idGFVJ0+rg1ucfcMU556e2kbz/yBoCJ1lF\n" +
            "AgMBAAGjeDB2MA4GA1UdDwEB/wQEAwIEsDATBgNVHSUEDDAKBggrBgEFBQcDATAP\n" +
            "BgNVHREECDAGhwTAqAECMB8GA1UdIwQYMBaAFKTgcGUyrJD1SNUcbEJPAPEYDJjs\n" +
            "MB0GA1UdDgQWBBRu8cyGOwQU1CjgFTIk7IGpHlubGzANBgkqhkiG9w0BAQsFAAOC\n" +
            "AQEAnYp95GwLHsPmh+apL0FCQP9ePnbKNY8zAzJisnpWlOnU0agqYyNwgZ+U7nvo\n" +
            "WIjMs1QbIpcHqpzPKEDrlErSIdOKolK5eSM/GLIuVbdTAeaFC06C1Xzbut40OZaX\n" +
            "jvJIYkcu8v5x6bGooWFj9pG5sEPFqQ9119Zw/MO/7aRjbTLg7p0s6ZDH6XQz8dzr\n" +
            "svLwEzgoZABy47KyFUwQToAm+qlR4Q9F8cQBU/rRCaBmdVIlcPCogQyUbeKRg/00\n" +
            "T9RdI4Ml0gCrrQBc+iBciWgtzOKqQXHGF/yyKIStJJg3nFZVL721oD0tMOo6REQU\n" +
            "Eg9yi6Du/D+9DvwyPDzoVN/qsg==\n" +
            "-----END CERTIFICATE-----\n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvresult = findViewById(R.id.qrResultText) as TextView

        qrButton = findViewById(R.id.scanQRButton) as Button

        qrButton!!.setOnClickListener {
            val intent = Intent(this@MainActivity, ScanQRCode::class.java)
            startActivity(intent)
        }

        sendTextButton = findViewById(R.id.sendTextMainButton) as Button

        sendTextButton!!.setOnClickListener {
//            val intent = Intent(applicationContext, SendTextActivity::class.java)
//            intent.putExtra("url", url)
//            startActivity(intent)
            if(url != "") {
                val intent = Intent(applicationContext, SendTextActivity::class.java)
                intent.putExtra("url", url)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext, "URL is empty", Toast.LENGTH_SHORT).show()
            }
        }

        qrResultText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                url = qrResultText.text.toString()
            }
        })

        RxPermissions(this)
            .request(Manifest.permission.CAMERA) // ask single or multiple permission once
            .subscribe({ granted ->
                if (granted) {
                    // All requested permissions are granted
                } else {
                    // At least one permission is denied
                }
            })

        RxPermissions(this)
            .request(Manifest.permission.INTERNET) // ask single or multiple permission once
            .subscribe({ granted ->
                if (granted) {
                    // All requested permissions are granted
                } else {
                    // At least one permission is denied
                }
            })

//        val derInputStream = ByteArrayInputStream(certificateString.byteInputStream())
//        val certificateFactory = CertificateFactory.getInstance("X.509", "BC")
//        val cert = certificateFactory.generateCertificate(derInputStream) as X509Certificate
//        val alias = "alias"//cert.getSubjectX500Principal().getName();
//
//        val trustStore = KeyStore.getInstance(KeyStore.getDefaultType())
//        trustStore.load(null)
//        trustStore.setCertificateEntry(alias, cert)
//        val kmf = KeyManagerFactory.getInstance("X509")
//        kmf.init(trustStore, null)
//        val keyManagers = kmf.getKeyManagers()
//
//        val tmf = TrustManagerFactory.getInstance("X509")
//        tmf.init(trustStore)
//        val trustManagers = tmf.getTrustManagers()
//
//        val sslContext = SSLContext.getInstance("TLS")
//        sslContext.init(keyManagers, trustManagers, null)
//        val url = URL(url)
//        conn = url.openConnection() as HttpsURLConnection
//        conn.setSSLSocketFactory(sslContext.getSocketFactory())
    }

    companion object {

        var tvresult: TextView? = null
    }
}
