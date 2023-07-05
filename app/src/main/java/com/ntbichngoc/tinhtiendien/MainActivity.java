package com.ntbichngoc.tinhtiendien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtChiSoCu, edtchiSoMoi, edtSoHo;
    TextView txtSoKwhDung, txtTienDien;

    DecimalFormat formatter = new DecimalFormat("#,###,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();


    }

    private void addControls() {
        edtChiSoCu = findViewById(R.id.edtChiSoCu);
        edtchiSoMoi = findViewById(R.id.edtChiSoMoi);
        edtSoHo = findViewById(R.id.edtSoHo);
        txtSoKwhDung = findViewById(R.id.txtSoKwhDung);
        txtTienDien = findViewById(R.id.txtTienDien);
    }

    public int tinhSoKwhDung(){
        int chiSoCu = Integer.parseInt(edtChiSoCu.getText().toString());
        int chiSoMoi = Integer.parseInt(edtchiSoMoi.getText().toString());
        int soKwhDung = chiSoMoi - chiSoCu;
        txtSoKwhDung.setText(formatter.format(soKwhDung) + " kWh");
        return soKwhDung;
    }

    public void tinhGiaSHBT(View view) {
        int soKwh = tinhSoKwhDung();
        double soHo = Double.parseDouble(edtSoHo.getText().toString());
        double giaSHBT;
        if (soKwh <= 50 * soHo)
        {
            giaSHBT = soKwh * 1484;
        }
        else if (soKwh <= 100 * soHo)
        {
            giaSHBT = (50*soHo*1484)+(soKwh-50*soHo)*1533;
        }
        else if (soKwh <= 200 * soHo)
        {
            giaSHBT = (50*soHo*1484)+(50*soHo*1533)+(soKwh-100*soHo)*1786;
        }
        else if (soKwh <= 300 * soHo)
        {
            giaSHBT = (50*soHo*1484)+(50*soHo*1533)+(100*soHo*1786)+(soKwh-200*soHo)*2242;
        }
        else if (soKwh <= 400 * soHo)
        {
            giaSHBT = (50*soHo*1484)+(50*soHo*1533)+(100*soHo*1786)+(100*soHo*2242)
                    +(soKwh-300*soHo)*2503;
        }
        else
        {
            giaSHBT = (50*soHo*1484)+(50*soHo*1533)+(100*soHo*1786)+(100*soHo*2242)
                    +(100*soHo*2503)+(soKwh-400*soHo)*2587;
        }
        txtTienDien.setText("Tổng số tiền điện giá sinh hoạt: " + formatter.format(giaSHBT) + " VNĐ");
    }

    public void tinhGiaKD(View view) {
        int soKwh = tinhSoKwhDung();
        int giaKD = soKwh * 2320;
        txtTienDien.setText("Tổng số tiền điện giá kinh doanh: " + formatter.format(giaKD) + " VNĐ");
    }

    public void tinhGiaSX(View view) {
        int soKwh = tinhSoKwhDung();
        int giaSX = soKwh * 1518;
        txtTienDien.setText("Tổng số tiền điện giá kinh doanh: " + formatter.format(giaSX) + " VNĐ");
    }

    public void xuLyXoa(View view) {
    }

    public void xuLyThoat(View view) {
        finish();
    }
}